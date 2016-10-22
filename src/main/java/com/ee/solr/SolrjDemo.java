package com.ee.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.apache.solr.common.params.SolrParams;

public class SolrjDemo {
	private static final String SOLR_URL = "http://192.168.3.176:8983/solr";
	
	public static void main(String[] args) throws SolrServerException, IOException {
		SolrClient client = new HttpSolrClient(SOLR_URL);
		// add
		System.out.println("====================solrj add begin");
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
		client.add("mysql_core", docs);
		client.commit("mysql_core");
		System.out.println("====================solrj add end");
		// query
//		System.out.println("====================solrj query begin");
//		ModifiableSolrParams params = new ModifiableSolrParams();
//		params.add("q", "*:*");
//		params.add("rows", "100");
//		QueryResponse resp = client.query("mysql_core", params);
//		for (SolrDocument doc : resp.getResults()) {
//			System.out.println(doc.getFieldValue("brandName"));
//		}
//		System.out.println("====================solrj query end");
		
		client.close();
	}
}
