package at.tugraz.ist.agile.recommenderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import at.tugraz.ist.agile.recommenderservice.marketplaces.AppMarketplace;
import at.tugraz.ist.agile.recommenderservice.marketplaces.CloudMarketplace;
import at.tugraz.ist.agile.recommenderservice.marketplaces.WorkflowMarketplace;
import at.tugraz.ist.agile.recommenderservice.marketplaces.parsers.ParseApp;
import at.tugraz.ist.agile.recommenderservice.marketplaces.parsers.ParseCloud;
import at.tugraz.ist.agile.recommenderservice.marketplaces.parsers.ParseWF;

@SpringBootApplication
public class SpringBootApplication_RecommenderService {

	public static void main(String[] args) {
		WorkflowMarketplace.initiate();
		ParseWF.getWorkFlows();
		WorkflowMarketplace.stopAddingToMarketplace();
		
		AppMarketplace.initiate();
		ParseApp.getAppList("IoT");
		AppMarketplace.stopAddingToMarketplace();
		
		CloudMarketplace.initiate();
		ParseCloud.getClouds();
		CloudMarketplace.stopAddingToMarketplace();
		
		SpringApplication.run(SpringBootApplication_RecommenderService.class, args);
	}
}
