package wheel.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import com.example.administrator.penghuidemo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
public class AddressTextAdapter extends AbstractWheelTextAdapter {
    List<String> list;

    public AddressTextAdapter(Context context, List<String> list, int currentItem, int maxsize, int minsize) {
        super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem, maxsize, minsize);
        this.list = list;
        setItemTextResource(R.id.tempValue);
    }

    @Override
    public View getItem(int index, View cachedView, ViewGroup parent) {
        View view = super.getItem(index, cachedView, parent);
        return view;
    }

    @Override
    public int getItemsCount() {
        return list.size();
    }

    @Override
    public CharSequence getItemText(int index) {
        return list.get(index) + "";
    }
}