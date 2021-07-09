package com.dl3213.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.dl3213.entity.Player;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// @Autowired
	// Log logger;
	//private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger( DemoApplicationTests.class);

	@Test
	void bytesBufferTest() {
		//log.debug("===========");
		FileChannel channel;
		try {
			channel = new FileInputStream("data.txt").getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(10);
			while (true) {
				int len = channel.read(buffer);// 从channel读，向buffer写
				System.out.println("now get => " + len);
				if(len == -1) break;
				buffer.flip();// 切换至读模式
				while (buffer.hasRemaining()) {
					byte b = buffer.get();
					System.out.println(" => " + (char) b);
				}
				buffer.clear();// 切换至写模式
			}

		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	@Test
	void sqlTest() {
		System.out.println("sqlTest");
		String sql = "SELECT pname FROM player WHERE pid = ?";
		String player1 = (String) jdbcTemplate.queryForObject(sql, new Object[] { 1 }, String.class);
		System.out.println(player1);
	}

	@Test
	void test01() {
		System.out.println("test01");

	}

	@Test
	void contextLoads() {
	}

}
