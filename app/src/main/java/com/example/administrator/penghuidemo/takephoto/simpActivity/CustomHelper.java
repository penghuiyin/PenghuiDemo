package com.example.administrator.penghuidemo.takephoto.simpActivity;

import android.net.Uri;
import android.os.Environment;
import android.view.View;

import com.chuangweixin.app.R;

import java.io.File;

import me.shaohui.advancedluban.Luban;
import takephoto.app.TakePhoto;
import takephoto.compress.CompressConfig;
import takephoto.model.CropOptions;
import takephoto.model.LubanOptions;
import takephoto.model.TakePhotoOptions;

public class CustomHelper{
    /** 选择照片的宽和高*/
    private int m_height=800;
    private int m_width=800;
    public static CustomHelper of(){
        return new CustomHelper();
    }
    private CustomHelper() {
    }

    public void setM_widthHeight(int width,int Height){
        m_height=Height;
        m_width=width;
    }

    /**
     * 选择图片 是不是裁剪
     * */

    public void setPicBySelect(TakePhoto takePhoto,int size,boolean isCrop){

        configCompress(takePhoto);
        configTakePhotoOpthion(takePhoto);
        int limit= size;
        if(isCrop){//是不是进行裁剪
            takePhoto.onPickMultipleWithCrop(limit,getCropOptions());
        }else {
            takePhoto.onPickMultiple(limit);
        }
    }

    /**
            * 照相 是不是裁剪
    * */

    public void setPicByTake(TakePhoto takePhoto,boolean isCrop){
        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+ System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOpthion(takePhoto);
        if(isCrop){
            takePhoto.onPickFromCaptureWithCrop(imageUri,getCropOptions());
        }else {
            takePhoto.onPickFromCapture(imageUri);
        }
    }
    private void configTakePhotoOpthion(TakePhoto takePhoto){
        if(true){
            takePhoto.setTakePhotoOptions(new TakePhotoOptions.Builder().setWithOwnGallery(true).create());
        }
    }
    private void configCompress(TakePhoto takePhoto){
        if(false){//是不是进行压缩
            takePhoto.onEnableCompress(null,false);
            return ;
        }
        int maxSize= 102400;//设置裁剪的大小
        int width= 800;
        int height= 800;
        CompressConfig config;
        if(true){
            config=new CompressConfig.Builder()//用自带的裁剪工具
                    .setMaxSize(maxSize)
                    .setMaxPixel(width>=height? width:height)
                    .create();
        }else {
            LubanOptions option=new LubanOptions.Builder() //三方的裁剪工具
                    .setGear(Luban.CUSTOM_GEAR)
                    .setMaxHeight(height)
                    .setMaxWidth(width)
                    .setMaxSize(maxSize)
                    .create();
            config=CompressConfig.ofLuban(option);
        }
        takePhoto.onEnableCompress(config,false);

    }
    private CropOptions getCropOptions(){
        int height= m_height;
        int width= m_width;
        CropOptions.Builder builder=new CropOptions.Builder();

//        if(rgCropSize.getCheckedRadioButtonId()==R.id.rbAspect){
            builder.setAspectX(width).setAspectY(height);//设置宽和高的比例
//        }else {
//            builder.setOutputX(width).setOutputY(height);//设置宽高的大小
//        }
        builder.setWithOwnCrop(false);//是不是用第三方的剪切工具
        return builder.create();
    }

}
