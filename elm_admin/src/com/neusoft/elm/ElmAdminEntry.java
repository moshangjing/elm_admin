package com.neusoft.elm;

import com.neusoft.elm.po.Admin;
import com.neusoft.elm.view.AdminView;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.impl.AdminViewImpl;
import com.neusoft.elm.view.impl.BusinessViewImpl;

import java.util.Scanner;

public class ElmAdminEntry {
    public void work() {
        Scanner input = new Scanner(System.in);
        AdminView adminView=new AdminViewImpl();
        BusinessView businessView = new BusinessViewImpl();
        Admin admin =adminView.login();
        if (admin!=null) {
            System.out.println("登录成功！");
            int menu = 0;
            while (menu != 9) {
                System.out.println("---------------------------饿了么后台管理系统---------------------------");
                System.out.println("\t1.所有商家列表;");
                System.out.println("\t2.搜索商家;");
                System.out.println("\t3.新建商家;");
                System.out.println("\t4.删除商家;");
                System.out.println("\t5.起送费排序;");
                System.out.println("\t6.配送费排序;");
                System.out.println("\t7.查询商家(起送费);");
                System.out.println("\t8.查询商家(配送费);");
                System.out.println("\t9.退出系统;");
                System.out.print("\t请输入您的选择：");
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        businessView.listBusinessAll();
                        break;
                    case 2:
                        businessView.listBusiness();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.removeBusiness();
                        break;
                    case 5:
                        System.out.println("请选择升序排列还是降序排列(升序为0，降序为1,默认为升序)：");
                        int c=0;
                        c=input.nextInt();
                        if(c==0){
                            businessView.showStarPrice();
                        }else{
                            businessView.showStarPrice2();
                        }
                        break;
                    case 6:
                        System.out.println("请选择升序排列还是降序排列(升序为0，降序为1,默认为升序)：");
                        int c2=0;
                        c2=input.nextInt();
                        if(c2==0){
                            businessView.showDeliveryPrice();
                        }else{
                            businessView.showDeliveryPrice2();
                        }
                        break;
                    case 7:
                        businessView.checkStarPrice();
                        break;
                    case 8:
                        businessView.checkDeliveryPrice();
                        break;
                    case 9:
                        System.out.println("尊敬的管理员，您已退出系统。");
                        System.out.println("欢迎您下次使用饿了么后台管理系统！");
                        System.out.println("----------------------------------------------------------------\n");
                        break;
                    default:
                        System.out.println("没有这个选项，请您重新输入！");
                        break;

                }
            }
        } else {
            System.out.println("\n管理员名称或密码输入错误，请您重新输入！");
        }
    }
    public static void main(String[] args) {
        new ElmAdminEntry().work();
    }
}



