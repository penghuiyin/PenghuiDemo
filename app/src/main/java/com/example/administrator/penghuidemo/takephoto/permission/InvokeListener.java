package com.example.administrator.penghuidemo.takephoto.permission;


import com.example.administrator.penghuidemo.takephoto.model.InvokeParam;

/**
 * 授权管理回调
 */
public interface InvokeListener {
    PermissionManager.TPermissionType invoke(InvokeParam invokeParam);
}
