package com.jinshu.settinglibrary.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.AddressDetailEntity;
import com.jinshu.settinglibrary.entity.AddressEntity;
import com.jinshu.settinglibrary.entity.AddressListEntity;
import com.jinshu.settinglibrary.entity.CityEntity;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.fragment.SelectAreaMenuDialogFragment;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.utils.permission.Acp;
import com.jinshu.settinglibrary.utils.permission.AcpListener;
import com.jinshu.settinglibrary.utils.permission.AcpOptions;
import com.jinshu.settinglibrary.widget.ViewStyle;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Create on 2019/10/10 16:55 by bll
 */

public class CreateAddressActivity extends SBaseActivity implements View.OnClickListener, SelectAreaMenuDialogFragment.OnSelectFinishClickListener {

    private EditText etReceiver, etPhone, etDetailAddress;
    private TextView tvLocation, tvArea;
    private Button btnHome, btnCompany, btnSchool, btnSubmit;
    private int addType;
    private ImageView ivDefault;
    private boolean isDefault;
    private int defaultStr;
    private String addressType;
    private AddressEntity.DataInfo.RowsInfo mInfo;
    public static final String ROOT_ID = "6ee7a940c0e048b7ba52fc22a6a5ad59";//获取省份的 id
    private AddressListEntity.DataInfo.RowsInfo addressInfo;
    private String provinceID;//省id
    private String provinceName;
    private String cityID;//市id
    private String cityName;
    private String xianID;//县id
    private String xianName;
    private String zhenID;//镇id
    private String zhenName;
    private String mapX;
    private String mapY;
    private View rlDefault;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_create_address;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setBackAction();
        etReceiver = findViewById(R.id.et_receiver);
        etPhone = findViewById(R.id.et_phone);
        etDetailAddress = findViewById(R.id.et_detail_address);
        tvLocation = findViewById(R.id.tv_location);
        tvArea = findViewById(R.id.tv_area);
        btnHome = findViewById(R.id.btn_home);
        btnCompany = findViewById(R.id.btn_company);
        btnSchool = findViewById(R.id.btn_school);
        ivDefault = findViewById(R.id.iv_default_address);
        rlDefault = findViewById(R.id.rl_default_address);
        btnSubmit = findViewById(R.id.btn_submit);

        ViewStyle.setBtnStyle(btnSubmit);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        addressType = bundle.getString(SAppConstant.ADDRESS_FLAG);
        if (Configure.CREATE.name().equals(addressType)) {
            setTitle("新建收货地址");
        } else if (Configure.UPDATE.name().equals(addressType)) {
            setTitle("编辑收货地址");
            setRightTitle("删除");
            addressInfo = (AddressListEntity.DataInfo.RowsInfo) bundle.getSerializable(SAppConstant.ADDRESS_INFO);
            if (addressInfo == null) {
                return;
            }

            getAddressDetail();
        }
    }

    private void getAddressDetail() {
        SApi.getDefault(SHostType.BASE_URL)
                .getOneMemberAddressDetail(MasterUtils.addSessionID(), addressInfo.getMemberAddressID())
                .compose(SRxSchedulers.<SBaseResponse<AddressDetailEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<AddressDetailEntity>>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse<AddressDetailEntity> baseResponse) {
                        if (baseResponse.header.code != 0) {
                            ToastUtil.showShort(baseResponse.header.msg);
                            return;
                        }
                        AddressDetailEntity.DataInfo addressInfo = baseResponse.body.getData();
                        if (addressInfo != null) {
                            etReceiver.setText(addressInfo.getContactName());
                            etPhone.setText(addressInfo.getPhone());
                            etDetailAddress.setText(addressInfo.getName());
                            String shengName = addressInfo.getShengName();
                            String shiName = StrUtils.isEmpty(addressInfo.getShiName()) ? "" : addressInfo.getShiName();
                            String xianName = StrUtils.isEmpty(addressInfo.getXianName()) ? "" : addressInfo.getXianName();
                            String zhenName = StrUtils.isEmpty(addressInfo.getZhenName()) ? "" : addressInfo.getZhenName();
                            String area = shengName + shiName + xianName + zhenName;
                            if (StrUtils.isEmpty(area)) {
                                checkAuthority();
                            } else {
                                tvArea.setText(area);
                            }
                            if (addressInfo.getAddType() == 1) {
                                setStatus(btnHome, btnSchool, btnCompany);
                            } else if (addressInfo.getAddType() == 2) {
                                setStatus(btnCompany, btnHome, btnSchool);
                            } else if (addressInfo.getAddType() == 3) {
                                setStatus(btnSchool, btnHome, btnCompany);
                            }
                            if (addressInfo.getIsDefault() == 1) {
                                isDefault = true;
                                ivDefault.setImageResource(R.drawable.setting_select);
                            } else {
                                isDefault = false;
                                ivDefault.setImageResource(R.drawable.setting_unselect);
                            }
                        }

                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });

    }

    private void setStatus(Button btn1, Button btn2, Button btn3) {
        btn1.setSelected(true);
        btn2.setSelected(false);
        btn3.setSelected(false);
        btn1.setTextColor(Color.WHITE);
        btn2.setTextColor(Color.BLACK);
        btn3.setTextColor(Color.BLACK);
    }

    private void setListener() {
        tvArea.setOnClickListener(this);
        tvLocation.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnCompany.setOnClickListener(this);
        btnSchool.setOnClickListener(this);
        rlDefault.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        setRightTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SApi.getDefault(SHostType.BASE_URL)
                        .deleteMyMemberAddress(MasterUtils.addSessionID(), addressInfo.getMemberAddressID())
                        .compose(SRxSchedulers.<SBaseResponse>io_main())
                        .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                            @Override
                            protected void onSuccess(SBaseResponse response) {
                                if (response.header.code == 0) {
                                    setResult(RESULT_OK);
                                    finish();
                                } else {
                                    ToastUtil.showShort(response.header.msg);
                                }
                            }

                            @Override
                            protected void onFail(String message) {
                                ToastUtil.showShort(message);
                            }
                        });
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_location) {
            checkAuthority();
        } else if (v.getId() == R.id.tv_area) {
            SelectAreaMenuDialogFragment dialogFragment = SelectAreaMenuDialogFragment.newInstance();
            dialogFragment.setCancelable(false);
            dialogFragment.setOnSelectFinishClickListener(this);
            dialogFragment.show(getSupportFragmentManager(), dialogFragment.getClass().getName());
        } else if (v.getId() == R.id.btn_home) {
            addType = 1;
            setStatus(btnHome, btnSchool, btnCompany);
        } else if (v.getId() == R.id.btn_company) {
            addType = 2;
            setStatus(btnCompany, btnHome, btnSchool);
        } else if (v.getId() == R.id.btn_school) {
            addType = 3;
            setStatus(btnSchool, btnHome, btnCompany);
        } else if (v.getId() == R.id.rl_default_address) {
            if (!isDefault) {
                ivDefault.setImageResource(R.drawable.setting_select);
                isDefault = true;
                defaultStr = 1;
                setDefault();
            } else {
                ivDefault.setImageResource(R.drawable.setting_unselect);
                isDefault = false;
            }
        } else if (v.getId() == R.id.btn_submit) {
            if (Configure.CREATE.name().equals(addressType)) {
                createMemberAddress();
            } else if (Configure.UPDATE.name().equals(addressType)) {
                updateMemberAddress();
            }
        }
    }

    private void setDefault() {
        if (Configure.UPDATE.name().equals(addressType)) {
            SApi.getDefault(SHostType.BASE_URL)
                    .setMemberAddressIsDefault(MasterUtils.addSessionID(), addressInfo.getMemberAddressID())
                    .compose(SRxSchedulers.<SBaseResponse>io_main())
                    .subscribe(new SRxSubscriber<SBaseResponse>(mContext, false) {
                        @Override
                        protected void onSuccess(SBaseResponse response) {
                            Log.d("bll", response.body.toString());
                        }

                        @Override
                        protected void onFail(String message) {
                            ToastUtil.showShort(message);
                        }
                    });
        }
    }

    /**
     * 新建地址
     */
    private void createMemberAddress() {
        String addressName = getStr(etDetailAddress);
        String contactName = getStr(etReceiver);
        String phone = getStr(etPhone);
        String area = tvArea.getText().toString();
        if (StrUtils.isEmpty(addressName) || StrUtils.isEmpty(contactName) || StrUtils.isEmpty(phone) || StrUtils.isEmpty(area)) {
            ToastUtil.showShort("请补充信息完整！");
        }
        SApi.getDefault(SHostType.BASE_URL)
                .createMemberAddress(
                        MasterUtils.addSessionID(),
                        addressName,
                        contactName,
                        defaultStr,
                        addType,
                        phone,
                        provinceID,
                        provinceName,
                        cityID,
                        cityName,
                        xianID,
                        xianName,
                        zhenID,
                        zhenName,
                        mapX,
                        mapY)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        setResult(RESULT_OK);
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });

    }

    private String getStr(EditText etText) {
        return etText.getText().toString().trim();
    }

    @Override
    public void onSelectFinish(AddressEntity.DataInfo.RowsInfo info, String area, String shengID, String shengName,
                               String cityID, String cityName, String xianID, String xianName, String zhenID, String zhenName) {
        tvArea.setText(area);
        this.mInfo = info;
        this.provinceID = shengID;
        this.provinceName = shengName;
        this.cityID = cityID;
        this.cityName = cityName;
        this.xianID = xianID;
        this.xianName = xianName;
        this.zhenID = zhenID;
        this.zhenName = zhenName;
        this.mapX = info.getMapX();
        this.mapY = info.getMapY();
    }

    /**
     * 修改地址
     */
    private void updateMemberAddress() {
        String addressName = getStr(etDetailAddress);
        String contactName = getStr(etReceiver);
        String phone = getStr(etPhone);
        String area = tvArea.getText().toString();
        if (StrUtils.isEmpty(addressName) || StrUtils.isEmpty(contactName) || StrUtils.isEmpty(phone) || StrUtils.isEmpty(area)) {
            ToastUtil.showShort("请补充信息完整！");
        }
        SApi.getDefault(SHostType.BASE_URL)
                .updateMemberAddress(
                        MasterUtils.addSessionID(),
                        addressName,
                        phone,
                        defaultStr,
                        addType,
                        addressInfo.getMemberAddressID(),
                        provinceID,
                        provinceName,
                        cityID,
                        cityName,
                        xianID,
                        xianName,
                        zhenID,
                        zhenName,
                        mapX,
                        mapY)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        setResult(RESULT_OK);
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void checkAuthority() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Acp.getInstance(mActivity).request(new AcpOptions.Builder().setPermissions(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            ).build(), new AcpListener() {
                @Override
                public void onGranted() {
                    getLocation();
                }

                @Override
                public void onDenied(List<String> permissions) {
                    ToastUtil.showShort("获取权限失败，请手动开启");
                }
            });
        } else {
            getLocation();
        }
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        LocationManager locMag = (LocationManager) mActivity.getSystemService(Context.LOCATION_SERVICE);
        if (!(locMag.isProviderEnabled(LocationManager.GPS_PROVIDER) || locMag.isProviderEnabled(LocationManager.NETWORK_PROVIDER))) {
            ToastUtil.showShort("请打开网络或GPS定位功能!");
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(intent, 0);
            return;
        }
        final List<String> providers = locMag.getProviders(true);
        for (String provider : providers) {
            @SuppressLint("MissingPermission")
            Location loc = locMag.getLastKnownLocation(provider);
            if (loc != null) {
                double lon = loc.getLongitude();//经度
                double lat = loc.getLatitude();
                Geocoder geocoder = new Geocoder(mActivity, Locale.getDefault());
                List<Address> locationList = null;
                try {
                    locationList = geocoder.getFromLocation(lat, lon, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (locationList.size() > 0) {
                    Address address = locationList.get(0);
                    String curLocation = address.getAddressLine(0);

                    etDetailAddress.setText(curLocation);
                    queryCityIDbyName(curLocation);
                }
            }
            LocationListener mListener = new LocationListener() {

                //当位置改变的时候调用
                @Override
                public void onLocationChanged(Location location) {
                    //刷新图层
                    double lon = location.getLongitude();
                    double lat = location.getLatitude();
                }

                //当GPS状态发生改变的时候调用
                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                //GPS开启的时候调用
                @Override
                public void onProviderEnabled(String provider) {
                }

                //GPS关闭的时候调用
                @Override
                public void onProviderDisabled(String provider) {
                }
            };
            locMag.requestLocationUpdates(provider, 100, 0, mListener);
        }
    }

    private void queryCityIDbyName(String cityName) {
        SApi.getDefault(SHostType.BASE_URL)
                .queryCityIDbyName(MasterUtils.addSessionID(), "", cityName)
                .compose(SRxHelper.<CityEntity>handleResult())
                .compose(SRxSchedulers.<CityEntity>io_main())
                .subscribe(new SRxSubscriber<CityEntity>(mContext, false) {
                    @Override
                    protected void onSuccess(CityEntity cityEntity) {

                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }
}
