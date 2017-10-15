package com.example.administrator.penghuidemo.takephoto.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import takephoto.compress.CompressConfig;
import takephoto.model.CropOptions;
import takephoto.model.MultipleCrop;
import takephoto.model.TException;
import takephoto.model.TResult;
import takephoto.model.TakePhotoOptions;
import takephoto.permission.PermissionManager;


public interface TakePhoto {
    /**
     * 图片多选
     * @param limit 最多选择图片张数的限制
     * */
    void onPickMultiple(int limit);
    /**
     * 图片多选，并裁切
     * @param limit 最多选择图片张数的限制
     * @param options  裁剪配置
     * */
    void onPickMultipleWithCrop(int limit, CropOptions options);
    /**
     * 从文件中获取图片（不裁剪）
     */
    void onPickFromDocuments();
    /**
     * 从文件中获取图片并裁剪
     * @param outPutUri 图片裁剪之后保存的路径
     * @param options 裁剪配置
     */
    void onPickFromDocumentsWithCrop(Uri outPutUri, CropOptions options);
    /**
     * 从相册中获取图片（不裁剪）
     */
    void onPickFromGallery();
    /**
     * 从相册中获取图片并裁剪
     * @param outPutUri 图片裁剪之后保存的路径
     * @param options 裁剪配置
     */
    void onPickFromGalleryWithCrop(Uri outPutUri, CropOptions options);

    /**
     * 从相机获取图片(不裁剪)
     * @param outPutUri 图片保存的路径
     */
    void onPickFromCapture(Uri outPutUri);
    /**
     * 从相机获取图片并裁剪
     * @param outPutUri 图片裁剪之后保存的路径
     * @param options 裁剪配置             
     */
    void onPickFromCaptureWithCrop(Uri outPutUri, CropOptions options);

    /**
     * 裁剪图片
     * @param imageUri 要裁剪的图片
     * @param outPutUri 图片裁剪之后保存的路径
     * @param options 裁剪配置
     */
    void onCrop(Uri imageUri, Uri outPutUri, CropOptions options)throws TException;
    /**
     * 裁剪多张图片
     * @param multipleCrop 要裁切的图片的路径以及输出路径
     * @param options 裁剪配置
     */
    void onCrop(MultipleCrop multipleCrop, CropOptions options)throws TException;
    void permissionNotify(PermissionManager.TPermissionType type);
    /**
     * 启用图片压缩
     * @param config 压缩图片配置
     * @param showCompressDialog 压缩时是否显示进度对话框
     */
    void onEnableCompress(CompressConfig config, boolean showCompressDialog);

    /**
     * 设置TakePhoto相关配置
     * @param options
     */
    void setTakePhotoOptions(TakePhotoOptions options);
    void onCreate(Bundle savedInstanceState);
    void onSaveInstanceState(Bundle outState);
    /**
     * 处理拍照或从相册选择的图片或裁剪的结果
     * @param requestCode
     * @param resultCode
     * @param data
     */
    void onActivityResult(int requestCode, int resultCode, Intent data);
    /**
     * 拍照结果监听接口
     */
    interface TakeResultListener {
        void takeSuccess(TResult result);

        void takeFail(TResult result, String msg);

        void takeCancel();
    }
}