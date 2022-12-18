public class filePath {

    public filePath(){

        for(int i = 1;i<= 40;i++){
            String str = "C:\\Users\\WITLAB\\PycharmProjects\\PyTorch-YOLOv3-master\\PyTorch-YOLOv3-master\\data\\plate\\images\\";

            str += i;
            str += ".png";

            System.out.println(str);
        }

    }
}
