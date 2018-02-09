package com.vp.plugin.sample.basicactivitydiagram.actions;

import java.awt.Point;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IActivityDiagramUIModel;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.IShapeUIModel;
import com.vp.plugin.diagram.connector.IControlFlowUIModel;
import com.vp.plugin.diagram.shape.IActivityActionUIModel;
import com.vp.plugin.diagram.shape.IActivityFinalUIModel;
import com.vp.plugin.diagram.shape.IActivityParameterNodeUIModel;
import com.vp.plugin.diagram.shape.IActivityUIModel;
import com.vp.plugin.diagram.shape.IDecisionNodeUIModel;
import com.vp.plugin.diagram.shape.IForkNodeUIModel;
import com.vp.plugin.diagram.shape.IInitialNodeUIModel;
import com.vp.plugin.diagram.shape.IJoinNodeUIModel;
import com.vp.plugin.diagram.shape.IMergeNodeUIModel;
import com.vp.plugin.diagram.shape.IObjectNodeUIModel;
import com.vp.plugin.model.IAction;
import com.vp.plugin.model.IActivity;
import com.vp.plugin.model.IActivityAction;
import com.vp.plugin.model.IActivityFinalNode;
import com.vp.plugin.model.IActivityObjectFlow;
import com.vp.plugin.model.IActivityParameterNode;
import com.vp.plugin.model.IControlFlow;
import com.vp.plugin.model.IDecisionNode;
import com.vp.plugin.model.IFork;
import com.vp.plugin.model.IForkNode;
import com.vp.plugin.model.IInitialNode;
import com.vp.plugin.model.IJoinNode;
import com.vp.plugin.model.IMergeNode;
import com.vp.plugin.model.IObjectFlow;
import com.vp.plugin.model.IObjectNode;
import com.vp.plugin.model.factory.IModelElementFactory;

public class BasicActivityDiagramActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// create blank activity diagram
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		IActivityDiagramUIModel diagram = (IActivityDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ACTIVITY_DIAGRAM);
		
		// create Process Order activity model
		IActivity activityProcessOrder = IModelElementFactory.instance().createActivity();
		// specify the name of the activity model
		activityProcessOrder.setName("Process Order");
		// specify the pre-condition & post-condition
		activityProcessOrder.setPrecondition("Order complete");
		activityProcessOrder.setPostcondition("Order closed");
		// set the activity as single execution
		activityProcessOrder.setSingleExecution(true);
		
		// create view for Process Order activity
		IActivityUIModel activityProcessOrderShape = (IActivityUIModel) diagramManager.createDiagramElement(diagram, activityProcessOrder);
		// specify its size and position
		activityProcessOrderShape.setBounds(173, 82, 790, 391);
		// set the caption placement to top left
		activityProcessOrderShape.setModelElementNameAlignment(IShapeUIModel.MODEL_ELEMENT_NAME_ALIGNMENT_ALIGN_TOP_LEFT);
		// set to automatic calculate the initial caption position
		activityProcessOrderShape.setRequestResetCaption(true);
		
		// create Requested Order activity parameter node
		IActivityParameterNode paramRequestedOrder = IModelElementFactory.instance().createActivityParameterNode();
		paramRequestedOrder.setName("Requested Order");
		// add the parameter node to Process Order activity 
		activityProcessOrder.addActivityParameterNode(paramRequestedOrder);
		
		// create view for Requested Order activity parameter node
		IActivityParameterNodeUIModel paramRequestedOrderShape = (IActivityParameterNodeUIModel) diagramManager.createDiagramElement(diagram, paramRequestedOrder);
		paramRequestedOrderShape.setBounds(126, 198, 95, 30);
		// add the view of Requested Order to Process Order
		activityProcessOrderShape.addChild(paramRequestedOrderShape);
		paramRequestedOrderShape.setRequestResetCaption(true);
		
		// create initial node & its view
		IInitialNode initialNode = IModelElementFactory.instance().createInitialNode();
		activityProcessOrder.addChild(initialNode);
		IInitialNodeUIModel initialNodeShape = (IInitialNodeUIModel) diagramManager.createDiagramElement(diagram, initialNode);
		initialNodeShape.setBounds(265, 148, 20, 20);
		activityProcessOrderShape.addChild(initialNodeShape);

		// create final node & its view
		IActivityFinalNode finalNode = IModelElementFactory.instance().createActivityFinalNode();
		IActivityFinalUIModel finalNodeShape = (IActivityFinalUIModel) diagramManager.createDiagramElement(diagram, finalNode);
		finalNodeShape.setBounds(885, 267, 20, 20);
		activityProcessOrderShape.addChild(finalNodeShape);
		
		// create Receive Order action & its view
		IActivityAction actionReceiveOrder = IModelElementFactory.instance().createActivityAction();
		actionReceiveOrder.setName("Receive Order");
		activityProcessOrder.addChild(actionReceiveOrder);		
		IActivityActionUIModel actionReceiveOrderShape = (IActivityActionUIModel) diagramManager.createDiagramElement(diagram, actionReceiveOrder);
		actionReceiveOrderShape.setBounds(255, 195, 60, 40);
		actionReceiveOrderShape.setRequestResetCaption(true);
		activityProcessOrderShape.addChild(actionReceiveOrderShape);
		
		// create Fill Order action & its view
		IActivityAction actionFillOrder = IModelElementFactory.instance().createActivityAction();
		actionFillOrder.setName("Fill Order");
		activityProcessOrder.addChild(actionFillOrder);
		IActivityActionUIModel actionFillOrderShape = (IActivityActionUIModel) diagramManager.createDiagramElement(diagram, actionFillOrder);
		actionFillOrderShape.setBounds(479, 195, 60, 40);
		actionFillOrderShape.setRequestResetCaption(true);
		activityProcessOrderShape.addChild(actionFillOrderShape);
		
		// create Ship Order action & its view
		IActivityAction actionShipOrder = IModelElementFactory.instance().createActivityAction();
		actionShipOrder.setName("Ship Order");
		activityProcessOrder.addChild(actionShipOrder);
		IActivityActionUIModel actionShipOrderShape = (IActivityActionUIModel) diagramManager.createDiagramElement(diagram, actionShipOrder);
		actionShipOrderShape.setBounds(641, 195, 60, 40);
		actionShipOrderShape.setRequestResetCaption(true);
		activityProcessOrderShape.addChild(actionShipOrderShape);
		
		// create Close Order action & its view
		IActivityAction actionCloseOrder = IModelElementFactory.instance().createActivityAction();
		actionCloseOrder.setName("Close Order");
		activityProcessOrder.addChild(actionCloseOrder);
		IActivityActionUIModel actionCloseOrderShape = (IActivityActionUIModel) diagramManager.createDiagramElement(diagram, actionCloseOrder);
		actionCloseOrderShape.setBounds(860, 195, 60, 40);
		actionCloseOrderShape.setRequestResetCaption(true);
		activityProcessOrderShape.addChild(actionCloseOrderShape);
		
		// create Send Invoice action & its view
		IActivityAction actionSendInvoice = IModelElementFactory.instance().createActivityAction();
		actionSendInvoice.setName("Send Invoice");
		activityProcessOrder.addChild(actionSendInvoice);
		IActivityActionUIModel actionSendInvoiceShape = (IActivityActionUIModel) diagramManager.createDiagramElement(diagram, actionSendInvoice);
		actionSendInvoiceShape.setBounds(263, 338, 60, 40);
		actionSendInvoiceShape.setRequestResetCaption(true);
		activityProcessOrderShape.addChild(actionSendInvoiceShape);
		
		// create Make Payment action & its view
		IActivityAction actionMakePayment = IModelElementFactory.instance().createActivityAction();
		actionMakePayment.setName("Make Payment");
		activityProcessOrder.addChild(actionMakePayment);
		IActivityActionUIModel actionMakePaymentShape = (IActivityActionUIModel) diagramManager.createDiagramElement(diagram, actionMakePayment);
		actionMakePaymentShape.setBounds(422, 338, 84, 40);
		actionMakePaymentShape.setRequestResetCaption(true);
		activityProcessOrderShape.addChild(actionMakePaymentShape);
		
		// create Accept Payment action & its view
		IActivityAction actionAcceptPayment = IModelElementFactory.instance().createActivityAction();
		actionAcceptPayment.setName("Accept Payment");
		activityProcessOrder.addChild(actionAcceptPayment);
		IActivityActionUIModel actionAcceptPaymentShape = (IActivityActionUIModel) diagramManager.createDiagramElement(diagram, actionAcceptPayment);
		actionAcceptPaymentShape.setBounds(562, 338, 91, 40);
		actionAcceptPaymentShape.setRequestResetCaption(true);
		activityProcessOrderShape.addChild(actionAcceptPaymentShape);
		
		// create decision node & its view
		IDecisionNode decision = IModelElementFactory.instance().createDecisionNode();
		IDecisionNodeUIModel decisionShape = (IDecisionNodeUIModel) diagramManager.createDiagramElement(diagram, decision);
		decisionShape.setBounds(373, 195, 20, 40);
		activityProcessOrderShape.addChild(decisionShape);
		
		// create merge node & its view
		IMergeNode merge = IModelElementFactory.instance().createMergeNode();
		IMergeNodeUIModel mergeShape = (IMergeNodeUIModel) diagramManager.createDiagramElement(diagram, merge);
		mergeShape.setBounds(809, 195, 20, 40);
		activityProcessOrderShape.addChild(mergeShape);
		
		// create fork node & its view
		IForkNode fork = IModelElementFactory.instance().createForkNode();
		IForkNodeUIModel forkShape = (IForkNodeUIModel) diagramManager.createDiagramElement(diagram, fork);
		forkShape.setBounds(574, 185, 12, 60);
		activityProcessOrderShape.addChild(forkShape);
		
		// create join node & its view
		IJoinNode join = IModelElementFactory.instance().createJoinNode();
		IJoinNodeUIModel joinShape = (IJoinNodeUIModel) diagramManager.createDiagramElement(diagram, join);
		joinShape.setBounds(756, 185, 12, 60);
		activityProcessOrderShape.addChild(joinShape);
		
		// create object node & its view
		IObjectNode objectNode = IModelElementFactory.instance().createObjectNode();
		objectNode.setName("Invoice");
		activityProcessOrder.addChild(objectNode);		
		IObjectNodeUIModel objectNodeShape = (IObjectNodeUIModel) diagramManager.createDiagramElement(diagram, objectNode);
		objectNodeShape.setBounds(333, 407, 80, 40);
		objectNodeShape.setRequestResetCaption(true);
		activityProcessOrderShape.addChild(objectNodeShape);
		
		// create object flow from Requested Order to Receive Order
		IActivityObjectFlow flowRequestedOrderReceivedOrder = IModelElementFactory.instance().createActivityObjectFlow();
		// specify the from & to end
		flowRequestedOrderReceivedOrder.setFrom(paramRequestedOrder);
		flowRequestedOrderReceivedOrder.setTo(actionReceiveOrder);
		// create connector into diagram
		diagramManager.createConnector(diagram, flowRequestedOrderReceivedOrder, paramRequestedOrderShape, actionReceiveOrderShape, new Point[] {new Point(221, 215), new Point(255, 215)});
		
		// create control flow from Initial Node to Receive Order
		IControlFlow flowInitialReceiveOrder = IModelElementFactory.instance().createControlFlow();
		flowInitialReceiveOrder.setFrom(initialNode);
		flowInitialReceiveOrder.setTo(actionReceiveOrder);
		diagramManager.createConnector(diagram, flowInitialReceiveOrder, initialNodeShape, actionReceiveOrderShape, null);
		
		IControlFlow flowReceivOrderDecision = IModelElementFactory.instance().createControlFlow();
		flowReceivOrderDecision.setFrom(actionReceiveOrder);
		flowReceivOrderDecision.setTo(decision);
		diagramManager.createConnector(diagram, flowReceivOrderDecision, actionReceiveOrderShape, decisionShape, new Point[] {new Point(315, 215), new Point(375, 215)});
		
		IControlFlow flowDecisionFillOrder = IModelElementFactory.instance().createControlFlow();
		flowDecisionFillOrder.setFrom(decision);
		flowDecisionFillOrder.setTo(actionFillOrder);
		// specify guard condition for control flow
		flowDecisionFillOrder.setGuard("order accepted");
		IControlFlowUIModel flowDecisionFillOrderShape = (IControlFlowUIModel) diagramManager.createConnector(diagram, flowDecisionFillOrder, decisionShape, actionFillOrderShape, null);
		// specify the size and bounds of the control flow caption
		flowDecisionFillOrderShape.getCaptionUIModel().setBounds(380, 220, 100, 20);
		
		IControlFlow flowFillOrderFork = IModelElementFactory.instance().createControlFlow();
		flowFillOrderFork.setFrom(actionFillOrder);
		flowFillOrderFork.setTo(fork);
		diagramManager.createConnector(diagram, flowFillOrderFork, actionFillOrderShape, forkShape, new Point[] {new Point(539, 215), new Point(574, 215)});
		
		IControlFlow flowForkShipOrder = IModelElementFactory.instance().createControlFlow();
		flowForkShipOrder.setFrom(fork);
		flowForkShipOrder.setTo(actionShipOrder);
		diagramManager.createConnector(diagram, flowForkShipOrder, forkShape, actionShipOrderShape, new Point[] {new Point(586, 208), new Point(641, 208)});
		
		IControlFlow flowForkSendInvoice = IModelElementFactory.instance().createControlFlow();
		flowForkSendInvoice.setFrom(fork);
		flowForkSendInvoice.setTo(actionSendInvoice);
		diagramManager.createConnector(diagram, flowForkSendInvoice, forkShape, actionSendInvoiceShape, new Point[] {new Point(586 ,230), new Point(600 ,230), new Point(600, 290), new Point(293 ,290), new Point(293 ,338)});
		
		IControlFlow flowShipOrderJoin = IModelElementFactory.instance().createControlFlow();
		flowShipOrderJoin.setFrom(actionShipOrder);
		flowShipOrderJoin.setTo(join);
		diagramManager.createConnector(diagram, flowShipOrderJoin, actionShipOrderShape, joinShape, new Point[] {new Point(701, 208), new Point(756, 208)});
		
		IControlFlow flowMakePaymentAcceptPayment = IModelElementFactory.instance().createControlFlow();
		flowMakePaymentAcceptPayment.setFrom(actionMakePayment);
		flowMakePaymentAcceptPayment.setTo(actionAcceptPayment);
		diagramManager.createConnector(diagram, flowMakePaymentAcceptPayment, actionMakePaymentShape, actionAcceptPaymentShape, new Point[] {new Point(506, 358), new Point(562, 358)});
		
		IControlFlow flowAcceptPaymentJoin = IModelElementFactory.instance().createControlFlow();
		flowAcceptPaymentJoin.setFrom(actionAcceptPayment);
		flowAcceptPaymentJoin.setTo(join);
		diagramManager.createConnector(diagram, flowAcceptPaymentJoin, actionAcceptPaymentShape, joinShape, new Point[] {new Point(653, 358), new Point(720, 358), new Point(720, 230), new Point(756, 230)});
		
		IControlFlow flowJoinMerge = IModelElementFactory.instance().createControlFlow();
		flowJoinMerge.setFrom(join);
		flowJoinMerge.setTo(merge);
		diagramManager.createConnector(diagram, flowJoinMerge, joinShape, mergeShape, new Point[] {new Point(768, 215), new Point(811, 215)});

		IControlFlow flowMergeCloseOrder = IModelElementFactory.instance().createControlFlow();
		flowMergeCloseOrder.setFrom(merge);
		flowMergeCloseOrder.setTo(actionCloseOrder);
		diagramManager.createConnector(diagram, flowMergeCloseOrder, mergeShape, actionCloseOrderShape, null);

		IControlFlow flowCloseOrderFinal = IModelElementFactory.instance().createControlFlow();
		flowCloseOrderFinal.setFrom(actionCloseOrder);
		flowCloseOrderFinal.setTo(finalNode);
		diagramManager.createConnector(diagram, flowCloseOrderFinal, actionCloseOrderShape, finalNodeShape, new Point[] {new Point(895, 235), new Point(895, 267)});
		
		IControlFlow flowDecisionMerge = IModelElementFactory.instance().createControlFlow();
		flowDecisionMerge.setFrom(decision);
		flowDecisionMerge.setTo(merge);
		flowDecisionMerge.setGuard("order rejected");
		IControlFlowUIModel flowDecisionMergeShape = (IControlFlowUIModel) diagramManager.createConnector(diagram, flowDecisionMerge, decisionShape, mergeShape, new Point[] {new Point(383, 202), new Point(383, 165), new Point(819, 165), new Point(819, 202)});
		flowDecisionMergeShape.getCaptionUIModel().setBounds(550, 147, 100, 20);
		
		// create object flow (IActivityObjectFlow)
		IActivityObjectFlow  flowSendInvoiceInvoice = IModelElementFactory.instance().createActivityObjectFlow();
		flowSendInvoiceInvoice.setFrom(actionSendInvoice);
		flowSendInvoiceInvoice.setTo(objectNode);
		diagramManager.createConnector(diagram, flowSendInvoiceInvoice, actionSendInvoiceShape, objectNodeShape, new Point[] {new Point(293, 378), new Point(293, 427), new Point(333, 427)});
		
		IActivityObjectFlow flowInvoiceMakePayment = IModelElementFactory.instance().createActivityObjectFlow();
		flowInvoiceMakePayment.setFrom(objectNode);
		flowInvoiceMakePayment.setTo(actionMakePayment);
		diagramManager.createConnector(diagram, flowInvoiceMakePayment, objectNodeShape, actionMakePaymentShape, new Point[] { new Point(413 ,427), new Point(464 ,427), new Point(464 ,378)});
		
		// show up the diagram		
		diagramManager.openDiagram(diagram);				
		
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
