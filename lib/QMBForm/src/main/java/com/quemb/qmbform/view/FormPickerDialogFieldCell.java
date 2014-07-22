package com.quemb.qmbform.view;

import com.quemb.qmbform.R;
import com.quemb.qmbform.descriptor.DataSourceListener;
import com.quemb.qmbform.descriptor.RowDescriptor;
import com.quemb.qmbform.descriptor.Value;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by tonimoeckel on 15.07.14.
 */
public class FormPickerDialogFieldCell extends FormDetailTextFieldCell {



    public FormPickerDialogFieldCell(Context context,
            RowDescriptor rowDescriptor) {
        super(context, rowDescriptor);
    }


    @Override
    public void onCellSelected() {
        super.onCellSelected();

        getRowDescriptor().getDataSource().loadData(new DataSourceListener() {
            @Override
            public void onDataSourceLoaded(ArrayList list) {

                /*
                final ArrayAdapter adapter = new ArrayAdapter(getContext(),0,list);

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(getRowDescriptor().getTitle())
                        .setSingleChoiceItems(adapter,0,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                onValueChanged(new Value<Object>(adapter.getItem(which)));
                                update();
                                dialog.dismiss();
                            }
                        });
                builder.show();
                */
                final ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_selectable_list_item,list);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setSingleChoiceItems(adapter,-1,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        onValueChanged(new Value<Object>(adapter.getItem(which)));
                        update();
                        dialog.dismiss();
                    }
                })
                        .setTitle("Test");

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}
