package catalog;
public class functions{
    public String getLoader(String path){
        String loader="";
        loader+="<img src='"+path+"img/loader.gif' width='100px' style='display:none;' id='loader'/>";
        loader+="<div id='errorMsg'></div>";
        return loader;
    }  
}
