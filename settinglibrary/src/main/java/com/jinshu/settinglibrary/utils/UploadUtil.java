package com.jinshu.settinglibrary.utils;


import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.entity.ImageEntity;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Create on 2019/6/6 15:28 by bll
 * 文件上传工具类
 */


public class UploadUtil {

    /**
     * 上传单张图片
     *
     * @param filePath 图片路径
     * @return
     */
    public static Observable<SBaseResponse<ImageEntity>> uploadImg(String filePath) {
        return uploadSingleImg(filePath);
    }

    /**
     * 上传多张图片
     *
     * @param filePaths 图片路径
     * @return
     */
    public static Observable<ResponseBody> uploadImgs(List<String> filePaths) {
        return uploadMoreImgs(filePaths);
    }

    /**
     * 图文混传
     *
     * @param json      普通参数
     * @param filePaths 图片路径
     * @return Observable
     */
    public static Observable<ResponseBody> uploadFile(String json, List<String> filePaths) {
        return uploadImgsWithParams(json, filePaths);
    }

    /**
     * 单张图片上传
     *
     * @param filePath 图片路径
     * @return Observable
     */
    private static Observable<SBaseResponse<ImageEntity>> uploadSingleImg(String filePath) {

        File file = new File(filePath);
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), body);
        return SApi.getDefault(SHostType.BASE_URL).uploadImg(part);
    }

    /**
     * 多张图片上传
     *
     * @param filePaths 图片路径
     * @return Observable
     */
    private static Observable<ResponseBody> uploadMoreImgs(List<String> filePaths) {
        Map<String, RequestBody> map = new HashMap<>();
        for (String path : filePaths) {
            File file = new File(path);
            map.put("files\";filename=\"" + file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }

        return SApi.getDefault(SHostType.BASE_URL).uploadImgs(map);
    }

    /**
     * 图片和参数同时上传的请求,图文混传,参数是json格式
     *
     * @param json      普通参数（json）
     * @param filePaths 图片路径
     * @return Observable
     */
    private static Observable<ResponseBody> uploadImgsWithParams(String json, List<String> filePaths) {

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        if (filePaths.size() != 0) {
            for (String path : filePaths) {
                File file = new File(path);
                RequestBody imageBody;
                String fileName;
                if (path.endsWith("mp4")) {
                    fileName = "video";
                    imageBody = RequestBody.create(MediaType.parse("video/mp4"), file);
                } else {
                    fileName = "picture";
                    imageBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
                }
                String name = null;
                try {
                    name = URLEncoder.encode(file.getName(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                builder.addFormDataPart(fileName, name, imageBody);
            }
        } else {
            builder.addFormDataPart("", "");
        }

        List<MultipartBody.Part> parts = builder.build().parts();
        return SApi.getDefault(SHostType.BASE_URL).uploadFileWithJson(body, parts);
    }


    /**
     * 图片和参数同时上传的请求,图文混传
     *
     * @param fileName  后台协定的接受图片的name（没特殊要求就可以随便写）
     * @param map       普通参数 (map格式)
     * @param filePaths 图片路径
     * @return Observable
     */
    private static Observable<ResponseBody> uploadImgsWithParams(String fileName, Map<String, Object> map, List<String> filePaths) {

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);

        if (null != map) {
            for (String key : map.keySet()) {
                builder.addFormDataPart(key, map.get(key) + "");
            }
        }

        for (String path : filePaths) {
            File file = new File(path);
            RequestBody imageBody;
            if (path.endsWith("mp4")) {
                fileName = "video";
                imageBody = RequestBody.create(MediaType.parse("video/mp4"), file);
            } else {
                fileName = "picture";
                imageBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
            }
            builder.addFormDataPart(fileName, file.getName(), imageBody);
        }

        List<MultipartBody.Part> parts = builder.build().parts();

        return SApi.getDefault(SHostType.BASE_URL).uploadFileWithMap(parts);

    }
}
