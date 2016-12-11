
package com.devzb.plugin;

import org.mybatis.generator.api.ShellRunner;

import com.devzb.framework.plugin.MybatisGeneratorPlugin;

public class MetalGeneratorStart {

	public static void main(String[] args) {
		String config = MybatisGeneratorPlugin.class.getClassLoader()
				.getResource("generatorConfig.xml").getFile();
		String[] arg = {"-configfile", config};
		ShellRunner.main(arg);
	}
}
