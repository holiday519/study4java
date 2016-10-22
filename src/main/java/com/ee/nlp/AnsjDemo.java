package com.ee.nlp;

import java.util.Collection;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;

public class AnsjDemo {

	public static void main(String[] args) {
		String content = "由联合国环境规划署组织20多个国家的55名科学家共同完成。报告指出，为了达到控制气温上升幅度的目标，2020年全球二氧化碳排放量需从2010年的约490亿吨降至440亿吨。但如果各国不采取有力行动，这个数值到2020年反而很可能上升到580亿吨；就算把现在世界各国最高程度的减排承诺加在一起，也会达到520亿吨，离目标仍然存在80亿吨的差距。与联合国环境规划署去年发布的报告相比，这个差距又扩大了20亿吨。联合国副秘书长、环境规划署执行主任阿希姆·施泰纳通过远程视频参加了当天的新闻发布会。他说：“严峻的事实说明全球向低碳和绿色经济模式的转变仍然太慢，达到440亿吨目标的机会正在逐年减小。”联合国环境规划署首席科学家约瑟夫·阿尔卡莫在接受新华社记者采访时强调，希望仍然存在。他说：“好消息是，全世界在交通、能源等领域仍然存在较大减排潜力，这份报告计算认为这个潜力总数可达170亿吨，如果我们能够努力把这些减排潜力变成现实，仍然可以达到与2摄氏度目标相应的减排要求。”新一轮联合国气候变化谈判即将于今年年底在卡塔尔首都多哈举行，《联合国气候变化框架公约》秘书处执行秘书克里斯蒂安娜·菲格雷斯也就这份报告表示，参加多哈会议的各国政府需要立即采取行动实现已有承诺，并设法把2020年的全球温室气体排放量控制在所需限度内。";
		KeyWordComputer kwc = new KeyWordComputer(5);
		Collection<Keyword> result = kwc.computeArticleTfidf(content);
        System.out.println(result);
	}
}
