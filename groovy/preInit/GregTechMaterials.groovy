import gregtech.api.GregTechAPI

eventManager.listen {
    GregTechAPI.PostMaterialEvent event ->
    println("Groovy finished modifying materials")
}