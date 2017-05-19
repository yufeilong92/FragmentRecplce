package com.example.dell.mywork;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyWork
 * @Package com.example.dell.mywork
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/5/18 9:01
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class ViewPagerAdapter extends FragmentPagerAdapter {



  private List<String> mData;
  private List<Fragment> mFragment;
  private Context mContext;


    public ViewPagerAdapter(FragmentManager fm, List<Fragment> mFragment,List<String> data,Context context) {
        super(fm);
        this.mData=data;
        this.mFragment=mFragment;
        this.mContext=context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position);
    }
}
