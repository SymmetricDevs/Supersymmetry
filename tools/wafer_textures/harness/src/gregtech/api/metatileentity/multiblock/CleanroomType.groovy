package gregtech.api.metatileentity.multiblock
class CleanroomType {
    String name
    CleanroomType(String n) { name = n }
    public static final CleanroomType CLEANROOM = new CleanroomType('cleanroom')
    public static final CleanroomType STERILE_CLEANROOM = new CleanroomType('sterile')
}
