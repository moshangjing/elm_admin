package com.neusoft.elm.dao;

import com.neusoft.elm.po.Business;

import java.util.List;

public interface BusinessDao {
    public List<Business> listBusiness(String businessName,String businessAddress);
    public int saveBusiness(String businessName);
    public int removeBusiness(int businessId);

    public Business getBusinessByIdByPass(Integer businessId,String password);
    public Business getBusinessById(Integer businessId);
    public int updateBusiness(Business business);
    public int updateBusinessByPassword(Integer businessId,String password);
    public List<Business> listStarPrice(String businessName,String businessAddress);
    public List<Business> listStarPrice2(String businessName,String businessAddress);
    public List<Business> listDeliveryPrice(String businessName,String businessAddress);
    public List<Business> listDeliveryPrice2(String businessName,String businessAddress);
    public List<Business> checkDeliveryPrice(int m);
    public List<Business> checkStarPrice(int m);
}
