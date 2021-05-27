package com.github.sankulgarg.leetcode.strings;
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        
        for(int i=strs[0].length();i>0;i--){
            String substr= strs[0].substring(0,i);
            boolean isPrefix=true;
            for(int j=1;j<strs.length;j++){
                if(!strs[j].startsWith(substr)){
                    isPrefix=false;
                    break;
                }
            }
            if(isPrefix)
            	return substr;
        }
        
        return "";
        
    }
}