package br.ufrn.movimentum.utils;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.movimentum.model.GroupLocal;

public class GroupLocalDefault {

    public static GroupLocal getLocalFrom(String nameLocal){
        GroupLocal groupLocal = new GroupLocal(nameLocal);
        List<LatLng> points = new ArrayList<>();
        points.add(new LatLng(-5.832816, -35.202946));
        points.add(new LatLng(-5.837005, -35.197561));
        points.add(new LatLng(-5.839940, -35.195490));
        points.add(new LatLng(-5.840687, -35.195211));
        points.add(new LatLng(-5.841530, -35.195200));
        points.add(new LatLng(-5.842544, -35.195307));
        points.add(new LatLng(-5.843451, -35.195919));
        points.add(new LatLng(-5.843867, -35.196906));
        points.add(new LatLng(-5.843867, -35.197292));
        points.add(new LatLng(-5.843515, -35.200575));
        points.add(new LatLng(-5.841890, -35.200548));
        points.add(new LatLng(-5.841570, -35.200977));
        points.add(new LatLng(-5.841346, -35.201138));
        points.add(new LatLng(-5.840417, -35.201095));
        points.add(new LatLng(-5.840342, -35.200902));
        points.add(new LatLng(-5.837628, -35.200959));
        points.add(new LatLng(-5.835198, -35.203053));
        points.add(new LatLng(-5.832816, -35.202946));
        groupLocal.setLatLng(points);
        return groupLocal;
    }

}
