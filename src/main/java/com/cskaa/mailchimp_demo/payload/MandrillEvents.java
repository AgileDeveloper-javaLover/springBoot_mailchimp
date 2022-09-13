package com.cskaa.mailchimp_demo.payload;

import lombok.Data;

import java.util.List;

@Data
public class MandrillEvents {
    private List<MandrillEventObj> mandrillEventObjList;
}
