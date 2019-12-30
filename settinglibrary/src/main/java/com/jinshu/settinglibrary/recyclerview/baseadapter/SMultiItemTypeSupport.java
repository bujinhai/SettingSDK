package com.jinshu.settinglibrary.recyclerview.baseadapter;

public interface SMultiItemTypeSupport<T>
{
	int getLayoutId(int itemType);

	int getItemViewType(int position, T t);
}