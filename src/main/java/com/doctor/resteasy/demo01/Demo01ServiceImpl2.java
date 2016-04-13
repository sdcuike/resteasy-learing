package com.doctor.resteasy.demo01;

import com.doctor.resteasy.common.ModelResult;

/**
 * 
 * @author sdcuike
 *
 *         Create At 2016年4月13日 下午4:39:17
 */
public class Demo01ServiceImpl2 implements Demo01Service {

    @Override
    public ModelResult<String> getMessage(Demo01Request demo01Request) {

        ModelResult<String> modelResult = new ModelResult<>();
        modelResult.setData("helllo " + demo01Request.getName() + " your age:" + demo01Request.getAge() + " ===2");
        return modelResult;
    }

}
