package com.jinshu.settinglibrary.utils;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.bigkoo.alertview.AlertView;
import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.utils.permission.Acp;
import com.jinshu.settinglibrary.utils.permission.AcpListener;
import com.jinshu.settinglibrary.utils.permission.AcpOptions;

import java.io.File;
import java.util.List;

/**
 * Created on 2020-02-11 by bll
 */

public class CameraUtils {

    private final static int RESULT_PICK_FROM_CAMERA = 0x211;
    private final static int RESULT_SELECT_PICTURE = 0x202;
    private static final int PHOTO_REQUEST_CUT = 0x203;
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    public static String mCameraTempFile = "" + System.currentTimeMillis() + PHOTO_FILE_NAME;

    public static void selectAvatar(final Activity activity) {
        new AlertView(activity.getString(R.string.setting_select_image_title), null,
                activity.getString(R.string.setting_common_cancel), null,
                new String[]{activity.getString(R.string.setting_select_image_camera),
                        activity.getString(R.string.setting_select_image_gallery)}, activity,
                AlertView.Style.ActionSheet, new com.bigkoo.alertview.OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                if (position == 0) {
                    //拍照
                    checkPermission(activity);
                } else if (position == 1) {
                    //相册
                    Intent albumIntent = new Intent(Intent.ACTION_PICK);
                    albumIntent.setType("image/*");
                    activity.startActivityForResult(albumIntent, RESULT_SELECT_PICTURE);
                }
            }
        }).show();
    }

    private static void checkPermission(final Activity activity) {
        Acp.getInstance(activity).request(new AcpOptions.Builder().setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CAMERA).build(), new AcpListener() {
            @Override
            public void onGranted() {
                pickImageFromCamera(activity);
            }

            @Override
            public void onDenied(List<String> permissions) {
                ToastUtil.showShort("获取权限失败，请手动开启");
            }
        });
    }

    /**
     * 拍照
     */
    private static void pickImageFromCamera(Activity activity) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        //判断存储卡是否可以用，可用进行存储
        if (FileUtils.checkSDcard()) {
            Uri uri = FileProviderUtils.getUriForFile(activity, new File(Environment.getExternalStorageDirectory(), mCameraTempFile));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }
        activity.startActivityForResult(intent, RESULT_PICK_FROM_CAMERA);
    }

    /**
     * 裁剪图片
     *
     * @param uri
     */
    public static void cropImage(Activity activity, Uri uri) {
        //剪裁图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        //裁剪框的比例，1:1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //裁剪后输出的图片的尺寸大小
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        //去黑边
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        //压缩图片
        intent.putExtra("outputFormat", "JPEG");
        //取消人脸识别
        intent.putExtra("noFaceDetection", true);
        /** return-data
         * 这个属性决定我们在 onActivityResult 中接收到的是什么数据，
         * 如果设置为true 那么data将会返回一个bitmap
         * 如果设置为false，则会将图片保存到本地并将对应的uri返回，当然这个uri得有我们自己设定。
         * 系统裁剪完成后将会将裁剪完成的图片保存在我们所这设定这个uri地址上。我们只需要在裁剪完成后直接调用该uri来设置图片，就可以了。
         */
        intent.putExtra("return-data", true);
        // 当 return-data 为 false 的时候需要设置这句
//        cropIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        activity.startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }


    /**
     * 7.0以上获取裁剪 Uri
     *
     * @param imageFile
     * @return
     */
    public static Uri getImageContentUri(Context context, File imageFile) {
        String filePath = imageFile.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID},
                MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            if (imageFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return context.getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }
}
