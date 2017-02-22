package com.ecgreb.losttest;

import com.mapzen.android.lost.api.LostApiClient;

import android.content.Context;

public class ConnectThenDisconnect implements LostApiClient.ConnectionCallbacks
{
  private final LostApiClient lostApiClient;

  public ConnectThenDisconnect(Context context)
  {
    lostApiClient = new LostApiClient.Builder(context).addConnectionCallbacks(this).build();
    lostApiClient.connect();
  }

  @Override public void onConnected() throws SecurityException
  {
    lostApiClient.disconnect();
  }

  @Override public void onConnectionSuspended() {}
}
