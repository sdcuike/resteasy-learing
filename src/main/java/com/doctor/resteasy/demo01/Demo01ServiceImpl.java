package com.doctor.resteasy.demo01;

import com.doctor.resteasy.common.ModelResult;

/**
 * @author sdcuike
 *
 *         Create At 2016年3月28日
 */
public class Demo01ServiceImpl implements Demo01Service {

    @Override
    public ModelResult<String> getMessage(Demo01Request demo01Request) {

        ModelResult<String> modelResult = new ModelResult<>();
        modelResult.setData("helllo " + demo01Request.getName() + " your age:" + demo01Request.getAge());
        return modelResult;
    }

}
