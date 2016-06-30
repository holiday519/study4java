package com.ee.solr;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class Test {
	private static final String SOLR_URL = "http://192.168.3.176:8983/solr/mysql_core";
	
	public static void main(String[] args) {
		List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
		SolrInputDocument doc1 = new SolrInputDocument();
		doc1.addField("id", 181);
		doc1.addField("brandId", "1001");
		doc1.addField("brandName", "噼里啪啦1号");
		docs.add(doc1);
		
		SolrInputDocument doc2 = new SolrInputDocument();
		doc2.addField("id", 182);
		doc2.addField("brandId", "1002");
		doc2.addField("brandName", "噼里啪啦2号");
		docs.add(doc2);
		
		SolrInputDocument doc3 = new SolrInputDocument();
		doc3.addField("id", 183);
		doc3.addField("brandId", "1003");
		doc3.addField("brandName", "噼里啪啦3号");
		docs.add(doc3);
		
		HttpSolrServer server = new HttpSolrServer(SOLR_URL);
	}
}
