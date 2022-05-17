package com.neusoft.elm.view;

import com.neusoft.elm.po.Business;

public interface BusinessView {
    public void listBusinessAll();
    public void listBusiness();
    public void saveBusiness();
    public void removeBusiness();
    public Business login();
    public void showBusiness(Integer businessId);
    public void editBusiness(Integer businessId);
    public void updateBusinessByPassword(Integer businessId);
    public void showStarPrice();   //升序
    public void showStarPrice2(); //降序
    public void showDeliveryPrice();
    public void showDeliveryPrice2();
    public void checkDeliveryPrice();
    public void checkStarPrice();
}
