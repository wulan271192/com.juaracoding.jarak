package com.juaracoding.jarak;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.juaracoding.jarak.function.HitungKecepatan;

public class TestingHitungKecepatan {
	
	HitungKecepatan kecepatan; //jawaban test8decjunit

	@Before
	public void setUp() throws Exception {
		kecepatan = new HitungKecepatan();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHitungKecepatan() {
		for (String isi :readfile("SkenarioRataRataKecepatan.csv")) {
			String [] data = isi.split(";");
			String jarak = data[0];
			String waktu = data[1];
			String hasil = data[2];
		assertEquals(Double.parseDouble(hasil), kecepatan.hitungKecepatan(Double.parseDouble(jarak), Double.parseDouble(waktu)), 0.0001);
	//	assertEquals(40, kecepatan.hitungKecepatan(200.0, 5.0),0.0001); //harus pake titik nol // jawaban nomor 1
	}
	}
	
	public List<String> readfile(String namefile){
		List<String> penampung = new ArrayList<String>();
		try {
			InputStream myFile = getClass().getClassLoader().getResourceAsStream(namefile);
			Scanner reader = new Scanner(myFile);
			
			while(reader.hasNextLine()) {
				penampung.add(reader.nextLine());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return penampung;
	}
	@Test
	public void testBukanAngka() {
	assertEquals(40, kecepatan.hitungKecepatan("aaaaa", 5.0),0.0001); //harus pake titik nol // jawaban nomor 2 bukan angka
	}
	@Test
	public void testAngkaNegatif() {
		assertEquals(40, kecepatan.hitungKecepatan(-200, -5.0),0.0001); //harus pake titik nol // jawaban nomor 3 angka negatif
	}
	public void testTidakAdaAngka() {
	assertEquals(0, kecepatan.hitungKecepatan(0,0),0.0001); //harus pake titik nol // jawaban nomor 4 dimasukan angka 0
	}
}
