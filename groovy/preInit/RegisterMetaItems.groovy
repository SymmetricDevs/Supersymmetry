import gregtech.api.items.metaitem.StandardMetaItem
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.GregTechAPI;

eventManager.listen {
    GregTechAPI.PostMaterialEvent event ->

        println("Running RegisterMetaItems.groovy...")

        println("Groovy starting modifying meta items")

        StandardMetaItem customMetaItems = new StandardMetaItem((short)2);
        customMetaItems.setRegistryName("meta_item_2")

        customMetaItems.addItem(1, "rock.carbon")
        customMetaItems.addItem(2, "rock.carbonate")
        customMetaItems.addItem(3, "rock.clay")
        customMetaItems.addItem(4, "rock.oxide")
        customMetaItems.addItem(5, "rock.phosphate")
        customMetaItems.addItem(6, "rock.precious")
        customMetaItems.addItem(7, "rock.radioactive")
        customMetaItems.addItem(8, "rock.sedimentary")
        customMetaItems.addItem(9, "rock.silicate")
        customMetaItems.addItem(10, "rock.sulfur")

        customMetaItems.addItem(1000, "chunk.magnetite")
        customMetaItems.addItem(1001, "hot_iron_rod")
        customMetaItems.addItem(1002, "voltaic_pile").setMaxStackSize(1);
        customMetaItems.addItem(1003, "electrolyte_paper")

        println("Groovy finished modifying meta items")
}