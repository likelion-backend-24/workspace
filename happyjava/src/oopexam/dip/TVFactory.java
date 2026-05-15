package oopexam.dip;

public class TVFactory {
    public static TV getTV(String type)
    {
        if("carami".equalsIgnoreCase(type))
        {
            return new CaramiTV();
        }else if("s".equalsIgnoreCase(type)){
            return new STV();
        }
        return null;
    }
}
