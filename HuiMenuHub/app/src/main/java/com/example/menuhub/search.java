package com.example.menuhub;

import android.widget.EditText;

public class search {
    private static search search_keyword =null;

   private search(){

    }
    public  String getkeyword(EditText etName) {

        return etName.getText().toString();

    }
    public static search getInstance(){

       if(search_keyword == null){
           search_keyword = new search();
       }
       return  search_keyword;

    }


}
