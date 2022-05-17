package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.po.Admin;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.util.DBUtil;

public class BusinessDaoImpl implements BusinessDao{
    private Connection con=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    public List<Business> listBusiness(String businessName,String businessAddress){
        List<Business> list=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select * from business where 1=1");
        if (businessName!=null&&!businessName.equals("")){
            sql.append(" and businessName like '%'+businessName+'%'");
        }
        if (businessAddress!=null&&!businessAddress.equals("")){
            sql.append("and businessAddress like '%'+businessAddress+'%'");
        }
        try{
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return list;
    }
    public List<Business> listStarPrice(String businessName,String businessAddress){
        List<Business> list=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select businessId,businessName,businessExplain,starPrice from business where 1=1 order by starPrice asc");
        if (businessName!=null&&!businessName.equals("")){
            sql.append(" and businessName like '%'+businessName+'%'");
        }
        if (businessAddress!=null&&!businessAddress.equals("")){
            sql.append("and businessAddress like '%'+businessAddress+'%'");
        }
        try{
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                list.add(business);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return list;
    }
    public List<Business> listStarPrice2(String businessName,String businessAddress){
        List<Business> list=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select businessId,businessName,businessExplain,starPrice from business where 1=1 order by starPrice desc");
        if (businessName!=null&&!businessName.equals("")){
            sql.append(" and businessName like '%'+businessName+'%'");
        }
        if (businessAddress!=null&&!businessAddress.equals("")){
            sql.append("and businessAddress like '%'+businessAddress+'%'");
        }
        try{
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                list.add(business);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return list;
    }
    public List<Business> listDeliveryPrice(String businessName,String businessAddress){
        List<Business> list=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select businessId,businessName,businessExplain,deliveryPrice from business where 1=1 order by deliveryPrice asc");
        if (businessName!=null&&!businessName.equals("")){
            sql.append(" and businessName like '%'+businessName+'%'");
        }
        if (businessAddress!=null&&!businessAddress.equals("")){
            sql.append("and businessAddress like '%'+businessAddress+'%'");
        }
        try{
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return list;
    }
    public List<Business> checkDeliveryPrice(int dp){
        List<Business> list=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select * from business where deliveryPrice <=? order by deliveryPrice asc");
        try{
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql.toString());
            pst.setInt(1,dp);
            rs = pst.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return list;
    }
    public List<Business> checkStarPrice(int dp){
        List<Business> list=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select * from business where starPrice >=? order by starPrice asc");
        try{
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql.toString());
            pst.setInt(1,dp);
            rs = pst.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return list;
    }
    public List<Business> listDeliveryPrice2(String businessName,String businessAddress){
        List<Business> list=new ArrayList<>();
        StringBuffer sql=new StringBuffer("select businessId,businessName,businessExplain,deliveryPrice from business where 1=1 order by deliveryPrice desc");
        if (businessName!=null&&!businessName.equals("")){
            sql.append(" and businessName like '%'+businessName+'%'");
        }
        if (businessAddress!=null&&!businessAddress.equals("")){
            sql.append("and businessAddress like '%'+businessAddress+'%'");
        }
        try{
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return list;
    }
    public int saveBusiness(String businessName){
        int businessId=0;
        String sql="insert into business(businessName,password) values(?,'123')";
        try{
            con= DBUtil.getConnection();
            pst=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1,businessName);
            pst.executeUpdate();
            rs=pst.getGeneratedKeys();//获取自增长列值
            if(rs.next()){
                businessId=rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return businessId;
    }
    public int removeBusiness(int businessId){
        int result=0;
        String delFootSql="delete from food where businessId=?";
        String delBusinessSql="delete from business where businessId=?";

        try{
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            pst = con.prepareStatement(delFootSql);
            pst.setInt(1,businessId);
            pst.executeUpdate();

            pst = con.prepareStatement(delBusinessSql);
            pst.setInt(1,businessId);
            result=pst.executeUpdate();
            con.commit();
        }catch(SQLException e){
            result=0;
            try{
                con.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(null,pst,con);
        }
        return result;
    }
    public Business getBusinessByIdByPass(Integer businessId,String password) {
        Business business = null;
        String sql = "select * from business where businessId=? and password=?";
        try{
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, businessId);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while(rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,pst,con);
        }
        return business;
    }
    public Business getBusinessById(Integer businessId) {
        Business business = null;
        String sql = "select * from business where businessId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, businessId);
            rs = pst.executeQuery();
            while(rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return business;
    }
    public int updateBusiness(Business business) {
        int result=0;
        String sql = "update business set businessName=?,businessAddress=?,businessExplain=?,starPrice=?,deliveryPrice=? where businessId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, business.getBusinessName());
            pst.setString(2, business.getBusinessAddress());
            pst.setString(3, business.getBusinessExplain());
            pst.setDouble(4, business.getStarPrice());
            pst.setDouble(5, business.getDeliveryPrice());
            pst.setInt(6, business.getBusinessId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }
    public int updateBusinessByPassword(Integer businessId,String password) {
        int result = 0;
        String sql = "update business set password=? where businessId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, password);
            pst.setInt(2, businessId);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }
}
