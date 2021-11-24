package com.cg.mavendemo;

import java.sql.SQLException;

import com.cg.mavendemo.database.Database;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	Database.add();
    }
}
