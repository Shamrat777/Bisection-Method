package bisectionnew;

import java.util.Scanner;

public class BisectionNew {
    
    public double fOfXu(double upper){
    double xu=(double)(Math.pow(upper, 4)-upper-10);
    return xu;
    }
    
     public double fOfXl(double lower){
    double xl=(double)(Math.pow(lower, 4)-lower-10);
    return xl;
    
    }
     
      public double fOfXm(double midvalue){
    double xl=(double)(Math.pow(midvalue, 4)-midvalue-10);
    return xl;
    
    }
     
     
     
     public double errorCount(double presentMidvalue, double pastMidvalue){
     
     double errorCount=(double)(((presentMidvalue-pastMidvalue)/presentMidvalue))*100;
     return errorCount;
     }
    
   
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
        BisectionNew object=new BisectionNew();
        
        double upper;
        double lower;
        double bisectionRange;
        double fOFxm;
        double fOFxl;
        double fOFxu;
        double midValue=0;
        double errorCount;
        double pastMidvalue=0;
        int i;
        System.out.println("Enter Your Upper Value");
        upper=sc.nextDouble();
        
        System.out.println("Enter Your Lower Value");
        lower=sc.nextDouble();
        
        System.out.println("Enter The Limit Of Iteration You Want to Find");
        bisectionRange=sc.nextDouble(); 
        
        fOFxu=object.fOfXu(upper);
        System.out.println("f(xu): "+fOFxu);
        
        fOFxl=object.fOfXl(lower);
        System.out.println("f(xl): "+fOFxl);
       
        for(i=1; i<= bisectionRange; i++){
        if(fOFxu*fOFxl>=0)//to cheak is there any root exist or not
        {
         System.out.println("There is no root,itearation is not possible beacause two values are positive");
         break;
       }
        
        
       else if(fOFxu*fOFxl <0)//from here 1st iteration start
       {
       System.out.println("iteration : "+i);
       midValue=(upper+lower)/2 ;
       double presentMidvalue=midValue;
       System.out.println("xm(Mid Value) :"+midValue);
       fOFxm=object.fOfXm(midValue);
       System.out.println("f(xm):"+fOFxm);
       if(fOFxl*fOFxm>0){//to cheak is the value is upper/lower than zero
       lower=midValue;
       upper=upper;
       System.out.println("xl: "+lower);
       System.out.println("xu: "+upper);
       }
       if(fOFxl*fOFxm<0){//to cheak is the value is upper/lower than zero
       lower=lower;
       upper=midValue;
       System.out.println("xl: "+lower);
       System.out.println("xu: "+upper);
       }
       if(i==1){
       System.out.println("Eror count is not possible untill second iteration");
       }
       if(i>1){//find out the error
       errorCount=object.errorCount(presentMidvalue, pastMidvalue);
       System.out.println("Eror : "+Math.abs(errorCount)+"%");
       
       }
       
       }
       pastMidvalue=midValue;
       }
       
}
}

    
   
 

    
    

