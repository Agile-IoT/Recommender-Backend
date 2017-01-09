package at.tugraz.ist.agile.recommenderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import at.tugraz.ist.agile.recommenderservice.marketplaces.AppMarketplace;
import at.tugraz.ist.agile.recommenderservice.marketplaces.CloudMarketplace;
import at.tugraz.ist.agile.recommenderservice.marketplaces.WorkflowMarketplace;
import at.tugraz.ist.agile.recommenderservice.marketplaces.parsers.ParseGooglePlayStore;
import at.tugraz.ist.agile.recommenderservice.marketplaces.parsers.ParseDockerHub;
import at.tugraz.ist.agile.recommenderservice.marketplaces.parsers.ParseCloud;
import at.tugraz.ist.agile.recommenderservice.marketplaces.parsers.ParseNodeRed;

@SpringBootApplication
public class SpringBootApplication_RecommenderService {

	public static void main(String[] args) {

		AppMarketplace.initiate();
		ParseDockerHub.getAppList("IoT");
		AppMarketplace.stopAddingToMarketplace();
		
		WorkflowMarketplace.initiate();
		ParseNodeRed.getWorkFlows();
		WorkflowMarketplace.stopAddingToMarketplace();
		
		CloudMarketplace.initiate();
		ParseCloud.getClouds();
		CloudMarketplace.stopAddingToMarketplace();
		
		SpringApplication.run(SpringBootApplication_RecommenderService.class, args);
	}
}
