package com.jinshu.settinglibrary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.AreaAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.AddressEntity;
import com.jinshu.settinglibrary.recyclerview.irc.OnItemClickListener;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.BottomMenuDialog;

import java.util.List;

/**
 * Create on 2019/10/13 17:50 by bll
 */


public class SelectAreaMenuDialogFragment extends BottomMenuDialog {

    private TextView tvSheng, tvCity, tvXian, tvZhen;
    private ImageView ivDelete;
    private RecyclerView mRecyclerView;
    private AreaAdapter mAdapter;
    private String rootID;//根id
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

    public static SelectAreaMenuDialogFragment newInstance() {
        SelectAreaMenuDialogFragment dialogFragment = new SelectAreaMenuDialogFragment();
        return dialogFragment;
    }

    public static SelectAreaMenuDialogFragment newInstance(String rootID) {
        Bundle bundle = new Bundle();
        bundle.putString(SAppConstant.ROOT_ID, rootID);
        SelectAreaMenuDialogFragment dialogFragment = new SelectAreaMenuDialogFragment();
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.setting_fragment_dialog_select_area;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvSheng = bindView(R.id.tv_sheng);
        tvCity = bindView(R.id.tv_city);
        tvXian = bindView(R.id.tv_xian);
        tvZhen = bindView(R.id.tv_zhen);
        mRecyclerView = bindView(R.id.recyclerView);
        ivDelete = bindView(R.id.iv_delete);

        mAdapter = new AreaAdapter(getContext(), R.layout.setting_adapter_item_select_area);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        setListener();
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            rootID = bundle.getString(SAppConstant.ROOT_ID);
        }
        AddressEntity.DataInfo.RowsInfo info = new AddressEntity.DataInfo.RowsInfo();
        info.setCityID(SAppConstant.CITY_ROOT_ID);
        getCityList(info, 1);
    }

    /**
     * 获取省市区县街道列表
     *
     * @param type 1：省/市  2：市/区  3：县/区  4：镇/乡
     */
    private void getCityList(final AddressEntity.DataInfo.RowsInfo info, final int type) {
        SApi.getDefault(SHostType.BASE_URL)
                .getCityList(MasterUtils.addSessionID(), 1, 10000, "1", info.getCityID())
                .compose(SRxSchedulers.<SBaseResponse<AddressEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<AddressEntity>>(getContext(), false) {
                    @Override
                    protected void onSuccess(SBaseResponse<AddressEntity> response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        if (response.body.getData() == null || response.body.getData().getRows() == null) {
                            return;
                        }
                        handleData(response.body.getData().getRows(), type, info);

                        mAdapter.replaceAll(response.body.getData().getRows());
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void handleData(List<AddressEntity.DataInfo.RowsInfo> infoList, int type, AddressEntity.DataInfo.RowsInfo rowsInfo) {
        if (infoList.size() == 0) {
            if (mListener != null) {
                if (type == 2) {
                    mListener.onSelectFinish(rowsInfo, provinceName, provinceID, provinceName, "", "", "", "", "", "");
                } else if (type == 3) {
                    mListener.onSelectFinish(rowsInfo, provinceName + cityName, provinceID, provinceName, cityID, cityName, "", "", "", "");
                } else if (type == 4) {
                    mListener.onSelectFinish(rowsInfo, provinceName + cityName + xianName, provinceID, provinceName, cityID, cityName, xianID, xianName, "", "");
                }
                dismiss();
            }
            return;
        }
        if (type == 1) {
            for (AddressEntity.DataInfo.RowsInfo info : infoList) {
                info.addressType = "1";
            }
        } else if (type == 2) {
            for (AddressEntity.DataInfo.RowsInfo info : infoList) {
                info.addressType = "2";
            }
        } else if (type == 3) {
            for (AddressEntity.DataInfo.RowsInfo info : infoList) {
                info.addressType = "3";
            }
        } else if (type == 4) {
            for (AddressEntity.DataInfo.RowsInfo info : infoList) {
                info.addressType = "4";
            }
        }
    }


    private void setListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                AddressEntity.DataInfo.RowsInfo info = (AddressEntity.DataInfo.RowsInfo) o;
                if ("1".equals(info.addressType)) {//省
                    provinceID = info.getCityID();
                    provinceName = info.getName();
                    tvSheng.setText(info.getName());
                    tvCity.setVisibility(View.VISIBLE);
                    getCityList(info, 2);
                } else if ("2".equals(info.addressType)) {//市
                    cityID = info.getCityID();
                    cityName = info.getName();
                    tvCity.setText(info.getName());
                    getCityList(info, 3);
                    tvXian.setVisibility(View.VISIBLE);
                } else if ("3".equals(info.addressType)) {//县
                    xianID = info.getCityID();
                    xianName = info.getName();
                    tvXian.setText(info.getName());
                    getCityList(info, 4);
                    tvZhen.setVisibility(View.VISIBLE);
                } else if ("4".equals(info.addressType)) {//镇/乡
                    if (!StrUtils.isEmpty(info.getName())) {
                        zhenID = info.getCityID();
                        zhenName = info.getName();
                        tvZhen.setText(info.getName());
                        if (mListener != null) {
                            mListener.onSelectFinish(info, provinceName + cityName + xianName + zhenName, provinceID,
                                    provinceName, cityID, cityName, xianID, xianName, zhenID, zhenName);
                            dismiss();
                        }
                    }
                }
            }
        });

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public interface OnSelectFinishClickListener {
        void onSelectFinish(AddressEntity.DataInfo.RowsInfo info, String area, String shengID, String shengName, String cityID, String cityName, String xianID, String xianName, String zhenID, String zhenName);
    }

    private OnSelectFinishClickListener mListener;

    public void setOnSelectFinishClickListener(OnSelectFinishClickListener listener) {
        this.mListener = listener;
    }
}
