package seclab.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/14
 * Time: 16:50
 * Description: 基础Channel实例
 */
public class FileChannelExample {

    public static void main(String[] args) {

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File("nio-file.txt"), "rw");

            // 获取随机读取文件的通道
            FileChannel fileChannel = randomAccessFile.getChannel();

            // 开辟48字节的字节缓存，用户缓存读取到的通道中的内容
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);

            // 将通道的内容读取到缓存，返回读取的字节数，读取结束后返回-1
            int readBytes = fileChannel.read(byteBuffer);

            System.out.println(byteBuffer.get());

            while (readBytes != -1) {

                // 输出读取的字节数
                System.out.println("Read: " + readBytes);

                // 读取buffer之前需要先flip一下
                byteBuffer.flip();

                // 开始读取字节
                while(byteBuffer.hasRemaining()){
                    System.out.println(byteBuffer.getChar());
                }

                // 清空缓存
                byteBuffer.clear();

                // 重新读取下一部分 48字节
                readBytes = fileChannel.read(byteBuffer);
            }

            // 记得关闭文件
            randomAccessFile.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
