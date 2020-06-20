fun main() {
    var bruto = ""

    bruto = bruto.replace("#EXTINF:-1 ","#")
    bruto = bruto.replace("tvg-id=","")
    bruto = bruto.replace(" tvg-logo=",",")
    bruto = bruto.replace(" tvg-name=",",")
    bruto = bruto.replace("group-title=",",")
    bruto = bruto.replace("http://list.",",http://list.")
    bruto = bruto.replace("\"","")
    bruto = bruto.replace("\n","")


    var channels = bruto.split("#")

    for (i in 1 until channels.size){
        var ok = channels[i].split(",")


        var id = ok[0]
        var name = ok[1]
        var logo = ok[2]
        var category = ok[3].replace("Series","Séries").replace("Musicas","Músicas").replace("Documentarios","Documentários")
        var url = ok[5]


        if (name.contains("FULL HD")){
            println("ChannelMaster(\"${id.replace(" ","").plus("_FULL_HD")}\",\"${name}\",\"$category\",\"${id.replace(" ","")}\",\"${logo.replace(" ","")}\",\"FULL_HD\",\"$url\",true),")
        }else if(name.contains("HD")){
            println("ChannelMaster(\"${id.replace(" ","").plus("_HD")}\",\"${name}\",\"$category\",\"${id.replace(" ","")}\",\"${logo.replace(" ","")}\",\"HD\",\"$url\",true),")
        } else if(name.contains("SD")) {
            println("ChannelMaster(\"${id.replace(" ","").plus("_SD")}\",\"${name}\",\"$category\",\"${id.replace(" ","")}\",\"${logo.replace(" ","")}\",\"SD\",\"$url\",true),")
        } else {
            println("ChannelMaster(\"${id.replace(" ","").plus("_SD")}\",\"${name.plus(" SD")}\",\"$category\",\"${id.replace(" ","")}\",\"${logo.replace(" ","")}\",\"SD\",\"$url\",true),")
        }

    }




}
