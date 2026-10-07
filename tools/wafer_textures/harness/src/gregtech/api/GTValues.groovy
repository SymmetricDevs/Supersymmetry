package gregtech.api
class GTValues {
    public static final int ULV=0, LV=1, MV=2, HV=3, EV=4, IV=5, LuV=6, ZPM=7, UV=8, UHV=9, UEV=10, UIV=11, UXV=12, OpV=13, MAX=14
    public static final int[] V = (0..14).collect { 8L * (4L ** it) > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)(8L * (4L ** it)) } as int[]
    public static final int[] VA = V.collect { (int)(it * 30 / 32) } as int[]
    public static final int[] VH = V
    public static final int[] VHA = VA
    public static final String[] VN = ["ULV","LV","MV","HV","EV","IV","LuV","ZPM","UV","UHV","UEV","UIV","UXV","OpV","MAX"] as String[]
    public static final String[] VNF = VN
}
