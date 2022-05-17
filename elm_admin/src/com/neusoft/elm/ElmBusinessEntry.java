package com.neusoft.elm;

import com.neusoft.elm.po.Business;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.FoodView;
import com.neusoft.elm.view.impl.BusinessViewImpl;
import com.neusoft.elm.view.impl.FoodViewImpl;

import java.util.Scanner;

public class ElmBusinessEntry {
    public void work(){
        Scanner input=new Scanner(System.in);
        System.out.println("---------------------------饿了么后台管理系统---------------------------");
        BusinessView businessView = new BusinessViewImpl();
        Business business= businessView.login();
        if(business!=null){
            int menu=0;
            while(menu!=5){
                //商家的一级菜单
                System.out.println("---------------------------商家一级菜单(商家管理)---------------------------");
                System.out.println("\t1.查看商家信息;");
                System.out.println("\t2.修改商家信息;");
                System.out.println("\t3.更新密码;");
                System.out.println("\t4.所属食品管理;");
                System.out.println("\t5.退出系统;");
                System.out.print("\t请输入您的选择：");
                menu=input.nextInt();
                switch (menu){
                    case 1:
                        businessView.showBusiness(business.getBusinessId());
                        break;
                    case 2:
                        businessView.editBusiness(business.getBusinessId());
                        break;
                    case 3:
                        businessView.updateBusinessByPassword(business.getBusinessId());
                        break;
                    case 4:
                        foodManager(business.getBusinessId());
                        break;
                    case 5:
                        System.out.println("尊敬的商家，您已退出系统。");
                        System.out.println("欢迎您下次使用饿了么后台管理系统！");
                        System.out.println("----------------------------------------------------------------\n");
                        break;
                    default:
                        System.out.println("没有这个选项，请您重新输入！");
                        break;
                }
            }
        }else{
            System.out.println("\n商家编号或密码输入错误，请您重新输入！");
        }

    }
    private void foodManager(int businessId){
        Scanner input=new Scanner(System.in);
        FoodView foodView=new FoodViewImpl();
        System.out.println("---------------------------饿了么后台管理系统---------------------------");
        int menu=0;
        while(menu!=5){
                //商家的二级菜单
            System.out.println("\t商家二级菜单(食品管理)");
            System.out.println("\t1.查看食品列表;");
            System.out.println("\t2.新增食品;");
            System.out.println("\t3.修改食品;");
            System.out.println("\t4.删除食品;");
            System.out.println("\t5.查看食品销售次数(升序排序);");
            System.out.println("\t6.返回一级菜单;");
            System.out.print("\t请输入您的选择：");
            menu=input.nextInt();
            switch (menu){
                case 1:
                    foodView.showFoodList(businessId);
                    break;
                case 2:
                    foodView.saveFood(businessId);
                    break;
                case 3:
                    foodView.updateFood(businessId);
                    break;
                case 4:
                    foodView.removeFood(businessId);
                    break;
                case 5:
                    foodView.showFoodCount(businessId);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("没有这个选项，请您重新输入！");
                    break;
                }
            }

    }
    public static void main(String[] args){
        new ElmBusinessEntry().work();
    }
}
