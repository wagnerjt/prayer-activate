package com.github.wagnerjt.prayeractivate;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class PrayerActivatePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(PrayerActivatePlugin.class);
		RuneLite.main(args);
	}
}