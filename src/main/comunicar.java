package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class comunicar implements iMensagem {

	File caixaMsg;
	FileChannel canal;
	MappedByteBuffer buffer;

	final int BUFFER_MAX = 30;

	public comunicar(String nome) {
		caixaMsg = new File(nome + ".dat");

		try {
			canal = new RandomAccessFile(caixaMsg, "rw").getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			buffer = canal.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_MAX);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enviarMsg(String msg) {
		// FIXME Auto-generated method stub
		for(int i = 0; i < msg.split(";").length; i++) {
			buffer.put(msg.split(";")[i].getBytes());
		}
	}

	@Override
	public String receberMsg() {
		// FIXME Auto-generated method stub
		return null;
	}
	
	public void fecharCanal() {
		try {
			canal.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		String msg = "0;1;11;34;54";
		comunicar teste = new comunicar("teste");
		teste.enviarMsg(msg);
	}
}