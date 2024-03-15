public class MismatchedParenthesesException extends Exception {
   int where; //at what index is the exception thrown?
   final static String desc = "MismatchedParenthesesException";
   public MismatchedParenthesesException (String message, int where){
      super(message);
      this.where = where;
   }
   public String getMessage(){
      return this.desc + ": " + super.getMessage();
   }
   public int getWhere(){
      return this.where + 1 + this.desc.length();
   }
}
