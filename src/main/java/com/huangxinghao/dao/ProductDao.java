package com.huangxinghao.dao;

import com.huangxinghao.model.Product;

import javax.xml.transform.Result;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,picture,price,CategoryId) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) {
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) {
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        String queryString = "selet * from Product where productId=?";
        PreparedStatement pt = con.prepareStatement(queryString);
        pt.setInt(1,productId);
        ResultSet rs = pt.executeQuery();
        Product product = new Product();
        while (rs.next())  {

            product.setProductId("ProductId");
            product.setProductName("ProductName");
            product.setProductDescription("ProductDescription");
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));

        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {

        List<Product> list=new ArrayList<Product>();
        String queryString = "selet * from Product where categoryId=?";
        PreparedStatement pt = con.prepareStatement(queryString);
        pt.setInt(1,categoryId);
        ResultSet rs = pt.executeQuery();
        while (rs.next())  {
            Product product = new Product();
            product.setProductId("ProductId");
            product.setProductName("ProductName");
            product.setProductDescription("ProductDescription");
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        String queryString = "selet * from Product";
        PreparedStatement pt = con.prepareStatement(queryString);
        ResultSet rs = pt.executeQuery();
        while (rs.next())  {
            Product product = new Product();
            product.setProductId("ProductId");
            product.setProductName("ProductName");
            product.setProductDescription("ProductDescription");
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        System.out.println("successful");
        return list;
        
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public byte[] getPictureById(Integer productId,Connection con)throws SQLException{
        byte[] imgbytes=null;
        String sql="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imgbytes=blob.getBytes(1,(int)blob.length());
        }
        return imgbytes;

    }


}
