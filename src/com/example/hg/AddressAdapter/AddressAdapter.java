package com.example.hg.AddressAdapter;

import java.util.List;

import android.content.Context;

public class AddressAdapter extends BBaseAdapter{
	private boolean isEdit=true;
	public AddressAdapter(Context context, List<Object> list, boolean isEdit){
		super(context, list);
		this.isEdit=isEdit;
	}
}
