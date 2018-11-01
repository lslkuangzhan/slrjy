package top.slrjy.edu.Util.Token;

/**
 * @ Author : Luc .
 * Date :  Created in  15:28.   2018/11/1.
 * 功能 :
 */
public class test {
    public static void main(String[] args) {
        //-qCkRwsj_b0gDRR14lziqM_Tgwbe9RRT
        //System.out.println( SignTokenUtil.genToken());
        try {
            System.out.println(SignTokenUtil.verificationToken("-qCkRwsj_b0gDRR14lziqM_Tgwbe9RRT"));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("发生未知错误!");
        }
    }

}
