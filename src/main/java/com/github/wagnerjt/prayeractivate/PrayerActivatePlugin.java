package com.github.wagnerjt.prayeractivate;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.SoundEffectID;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Prayer Activate",
	description = "Changes the sound when certain prayers are activated",
	tags = {"sound", "prayer"},
	enabledByDefault = true
)
public class PrayerActivatePlugin extends Plugin
{
	@Inject
	private ClientThread clientThread;

	@Inject
	private Client client;

	@Subscribe
	public void onSoundEffectPlayed(SoundEffectPlayed event)
	{
		// Check if the sound effect played is the one for activating the Zeal prayer
		if (event.getSoundId() == 12645 /*SoundEffectID.PRAYER_ACTIVATE_ZEAL*/)
		{
			event.consume();
			clientThread.invokeLater(() -> client.playSoundEffect(SoundEffectID.PRAYER_ACTIVATE_PIETY));
		}
	}
}