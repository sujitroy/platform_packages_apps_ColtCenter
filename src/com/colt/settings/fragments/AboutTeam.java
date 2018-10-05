package com.colt.settings.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.android.internal.logging.nano.MetricsProto;

import com.colt.settings.fragments.common.AboutTeamAdapter;
import com.colt.settings.fragments.common.AboutTeamAdapter.About;
import com.colt.settings.fragments.common.AboutTeamAdapter.Dev;
import com.colt.settings.fragments.common.AboutTeamAdapter.Team;
import com.colt.settings.fragments.common.AboutTeamAdapter.Header;
import com.colt.settings.fragments.common.AboutTeamAdapter.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class AboutTeam extends SettingsPreferenceFragment {

	private List<AboutTeamAdapter.About> list = new ArrayList<>();

	@Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_team, null);
        return v;
    }

    @Override
    	public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.about_team_title);
	initList();

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AboutTeamAdapter(list, new AboutTeamAdapter.OnClickListener() {
            @Override
            public void OnClick(String url) {
                if (!url.isEmpty()) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }
            }
        }));
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.COLT;
    }

    private void initList() {
        List<AboutTeamAdapter.Dev> team = new ArrayList<>();
        team.add(new AboutTeamAdapter.Dev(
                "Rakesh Batra",
                "Founder and Lead ROM Developer",
                "https://github.com/Colt-Enigma/colt_avtaars/avtaar.png",
                "https://forum.xda-developers.com/member.php?u=5985430",
                "",
                "https://t.me/RakeshBatra"
        ));
        team.add(new AboutTeamAdapter.Dev(
                "Nitin Chobhe",
                "ROM Developer",
                "https://github.com/Colt-Enigma/colt_avtaars/avtaar.png",
                "https://forum.xda-developers.com/member.php?u=5044214",
                "",
                "https://t.me/Nitin1438"
        ));
        list.add(new AboutTeamAdapter.Team(
                        "http://github.com/Colt-Enigma",
                        "https://t.me/ColtEnigma",
                        team

                )
        );
        list.add(new AboutTeamAdapter.Header());
        list.add(new AboutTeamAdapter.Maintainer(
                        "OnePlus3/3T Unified",
                        new AboutTeamAdapter.Dev(
                                "Rakesh Batra",
                                "",
                                "https://github.com/Colt-Enigma/colt_avtaars/avtaar.png",
                                "https://forum.xda-developers.com/oneplus-3/oneplus-3--3t-cross-device-development/rom-coltos-t3808635",
                                "https://github.com/RakeshBatra",
                                ""
                        )
                )
        );
        list.add(new AboutTeamAdapter.Maintainer(
                        "Pixel 2 XL (taimen)",
                        new AboutTeamAdapter.Dev(
                                "Nitin Chobhe",
                                "",
                                "https://github.com/Colt-Enigma/colt_avtaars/avtaar.png",
                                "https://forum.xda-developers.com/oneplus-3/oneplus-3--3t-cross-device-development/rom-coltos-t3808635",
                                "https://github.com/nitin1438",
                                ""
                        )
                )
        );
    }
}
