package com.example.administrator.penghuidemo.example.activty;

import android.os.Bundle;

import com.example.administrator.penghuidemo.takephoto.app.TakePhotoActivity;
import com.example.administrator.penghuidemo.takephoto.model.TImage;
import com.example.administrator.penghuidemo.takephoto.model.TResult;
import com.example.administrator.penghuidemo.takephoto.simpActivity.CustomHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by My on 2017/10/16.
 */

public class TokoActivity extends TakePhotoActivity{
    private CustomHelper customHelper;
    private int limit;//选择照片的个数
    private List<String> fileNameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customHelper=CustomHelper.of();
        fileNameList=new ArrayList<>();
        pickPhoto(200,300);
    }

    public void pickPhoto(int width,int height){
        customHelper.setM_widthHeight(width,height);
        pickPhoto();
    }

    public void takePhoto(int width,int height){
        customHelper.setM_widthHeight(width,height);
        takePhoto();
    }

    public void pickPhoto() {
        customHelper.setPicBySelect(getTakePhoto(),1,true);
    }
    /**
     * 个数
     * 是不是裁剪
     * */
    public void pickPhoto(int limit,boolean isCorp) {
        customHelper.setPicBySelect(getTakePhoto(),limit,isCorp);
    }
    public void takePhoto(boolean isCorp) {
        customHelper.setPicByTake(getTakePhoto(),isCorp);
    }
    public void takePhoto() {
        customHelper.setPicByTake(getTakePhoto(),true);
    }
    /** 单选返回的单张图片*/
    public void upLoadFile(String filePath){

    }
    /** 返回图片的集合*/
    public void upLoadFile(List<String> filePath){

    }
    @Override
    public void takeCancel() {
        super.takeCancel();
    }
    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result,msg);
    }
    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        showImg(result.getImages());
    }

    private void showImg(ArrayList<TImage> images) {
        fileNameList.clear();
        for (int i = 0; i <images.size() ; i++) {
            fileNameList.add(images.get(i).getPath());
        }
        upLoadFile(fileNameList);
        if (images.size()==1)
            upLoadFile(images.get(0).getPath());


    }
}
