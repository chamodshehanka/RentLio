package com.chamodshehanka.rentLioClient.util;

/**
 * @author chamodshehanka on 4/12/2018
 * @project RentLio
 **/
public class IDGenerator {

    public static String getNewID(String tblName, String prefix) throws Exception {
        String lastId = IDController.getLastID(tblName);
        String newId;
        if (lastId != null) {
            StringBuilder Id= new StringBuilder();
            char[] reg = lastId.toCharArray();
            for(int i=1;i < reg.length;i++){
                Id.append(reg[i]);
            }
            int r = Integer.parseInt(Id.toString());
            if(r < 9){
                newId = prefix + "00" +(r + 1);
            }else if(r < 99){
                newId = prefix + "0" + (r + 1);
            }else
                newId = prefix + (r + 1);
        }else{
            newId = prefix + "001";
        }
        return newId;
    }

}
