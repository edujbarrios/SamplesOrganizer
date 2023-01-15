import java.io.File;

public class CrearSubCarpetas {
    public static void main(String[] args) {
        // Directorio de descargas
        File descargas = new File("C:\\Users\\username\\Downloads");

        // Array de archivos existentes
        File[] archivos = descargas.listFiles();

        // Recorrer los archivos existentes
        for (File archivo : archivos) {
            // Obtener la extensión del archivo
            String extension = getFileExtension(archivo);

            // Crear la carpeta de acuerdo a la extensión del archivo
            File carpeta = new File(descargas, extension);
            carpeta.mkdir();

            // Mover el archivo a la nueva carpeta
            archivo.renameTo(new File(carpeta, archivo.getName()));
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
